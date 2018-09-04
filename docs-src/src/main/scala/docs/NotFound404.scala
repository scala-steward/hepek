package docs

import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.implicits._
import utils.Site
import utils.Imports._

object NotFound extends templates.HepekDocsPage {

  override def pageSettings = PageSettings("Doesn't exist")

  override def fileName = "404.html"

  override def relTo(other: RelativePath) =
    Site.url + "/" + super.relTo(other)

  override def pageContent = div(cls := "text-center")(
    md("""
      This page does not exist... :/  
      Click 
    """),
    hyperlink(Site.url)("here"),
    md(" to go back")
  )

}
