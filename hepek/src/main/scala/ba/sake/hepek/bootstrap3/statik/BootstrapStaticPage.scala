package ba.sake.hepek.bootstrap3

package statik

import ba.sake.hepek.bootstrap3.component.BootstrapNavbarComponents
import ba.sake.hepek.bootstrap3.component.classes.BootstrapClassesBundle._
import ba.sake.hepek.html.statik.StaticPage
import ba.sake.hepek.scalatags.all._

trait BootstrapStaticPage extends StaticPage with BootstrapPage {
  def navbar: Option[BootstrapNavbarComponents] = None

  override def bodyContent: Frag =
    div(clsContainerFluid)(
      div(clsNoPrint)(maybeNavbar),
      pageContent
    )

  /* NAVBAR */
  private def maybeNavbar =
    navbar.map { bsNav =>
      bsNav.nav(
        brandUrl = staticSiteSettings.indexPage.map(_.ref).getOrElse("#"),
        brandName = siteSettings.name.map(" " + _),
        brandIconUrl = siteSettings.faviconInverted,
        right = for
          page <- staticSiteSettings.mainPages
          labela = page.pageCategory.getOrElse(page.pageSettings.label)
        yield bsNav.link(page.ref, labela)
      )
    }

}
