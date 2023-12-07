package ba.sake.hepek.bulma.component

import ba.sake.hepek.html.component.NavbarComponents
import ba.sake.hepek.scalatags.all.{style => _, Style => _, _}

object BulmaNavbarComponent {
  sealed trait Position { def classes: String }

  object Position {
    case object FixedTop    extends Position { def classes = "is-fixed-top"    }
    case object FixedBottom extends Position { def classes = "is-fixed-bottom" }
  }

  sealed trait Width { def classes: String }

  object Width {
    case object Fixed extends Width { def classes = "container"       }
    case object Fluid extends Width { def classes = "container-fluid" }
  }

  final class Style(val classes: String)
}

class BulmaNavbarComponent(
    activeUrl: String = "",
    style: Option[BulmaNavbarComponent.Style] = None,
    position: Option[BulmaNavbarComponent.Position] = Some(BulmaNavbarComponent.Position.FixedTop),
    collapseId: String = "main-navbar"
) extends NavbarComponents {

  private val toggle =
    a(
      cls         := "navbar-burger burger",
      data.target := collapseId,
      onclick     := "document.querySelector('.navbar-menu').classList.toggle('is-active');"
      // ugly hack: https://github.com/jgthms/bulma/issues/856#issuecomment-502072770
    )(
      span(),
      span(),
      span()
    )

  val Companion = BulmaNavbarComponent

  def withActiveUrl(activeUrl: String): BulmaNavbarComponent =
    new BulmaNavbarComponent(activeUrl = activeUrl)

  def nav(
      brandUrl: String,
      brandName: Option[String] = None,
      brandIconUrl: Option[String] = None,
      left: Seq[Frag] = Seq.empty,
      right: Seq[Frag] = Seq.empty
  ): Frag =
    tag("nav")(cls := s"""navbar ${style
      .map(_.classes)
      .getOrElse("")} ${position.map(_.classes).getOrElse("")}""")(
      div(cls := "navbar-brand")(
        a(cls := "navbar-item", href := brandUrl)(
          brandIconUrl.map(url => img(src := url)),
          brandName
        ),
        toggle
      ),
      div(cls := "navbar-menu", id := collapseId)(
        div(cls := "navbar-start")(left),
        div(cls := "navbar-end")(right)
      )
    )

  override def link(url: String, content: Frag): Frag =
    div(cls := "navbar-item", Option.when(url == activeUrl)(cls := "active"))(content)

  override def dropdown(
      content: Frag,
      dropdownItems: Seq[Frag] = Seq.empty
  ): Frag =
    div(cls := "navbar-item has-dropdown is-hoverable")(
      a(cls := "navbar-link")(content),
      div(cls := "navbar-dropdown")(
        dropdownItems
      )
    )
}
