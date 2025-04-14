package files

import utils.Imports.Bundle.*
import Tags.*
import Grid.*

object Index extends templates.HepekDocsStaticPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Welcome!")
      .withDescription("Hepek docs")

  override def pageContent =
    div(cls := "container")(
      Navbar.nav(
        brandUrl = staticSiteSettings.indexPage.map(_.ref).getOrElse("#"),
        brandName = siteSettings.name.map(" " + _),
        brandIconUrl = siteSettings.faviconInverted,
        // TODO add to other pages too
        left = form(action := SearchResults.ref, method := "GET", cls := "form-inline")(
          input(
            name        := "q",
            tpe         := "search",
            cls         := "form-control",
            placeholder := "Search"
          )
        ),
        right = for
          page <- staticSiteSettings.mainPages
          labela = page.pageCategory.getOrElse(page.pageSettings.label)
        yield Navbar.link(page.ref, labela)
      ),
      row(
        s"""
          Hepek is a collection of useful projects for making websites in Scala:
          - [Components](${hepek.components.Index.ref}) (JVM and ScalaJS)
          - [Static Site Generator](${hepek.Index.ref})
          - [Framework Integrations](${integrations.Index.ref})

          ## Hepek Components
          Components is a standalone library with minimal dependencies.  
          They provide utilites for grid, form inputs, panels, navbars, markdown, code highlighting, maths rendering and lots more.  
          Components support frameworks like Bootstrap 5, Bulma, HTMX etc.  
          You can switch to a different framework with minimal effort and override parts you don't like.

          ## Hepek SSG
          SSG has support for automatic relative links, PDF rendering and lots more.

          ## Hepek Frameworks Integrations
          Integrations provide Hepek Components support for various frameworks:
            [Sharaf](https://github.com/sake92/sharaf), 
            [Play](https://www.playframework.com/),
            [Http4s](https://http4s.org),
            [ZIO Http](https://zio.dev/zio-http/).
          
          For any questions/bugs/features please make an issue in the [GitHub](https://github.com/sake92/hepek/issues) repo,
          and you can also join our [Discord chat](https://discord.gg/R2FtxDKyRE)
        """.md
      ),
      super.pageContent
    )

}
