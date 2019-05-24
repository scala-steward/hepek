package ba.sake.hepek
import ba.sake.hepek.bootstrap3.component.classes.BootstrapTextClasses
import ba.sake.hepek.bootstrap3.component.classes.BootstrapButtonClasses
import ba.sake.hepek.bootstrap3.component.classes.BootstrapBackgroundClasses
import ba.sake.hepek.bulma.component.classes.BulmaTextClasses
import ba.sake.hepek.bulma.component.classes.BulmaButtonClasses
import ba.sake.hepek.bulma.component.classes.BulmaBackgroundClasses

private[hepek] trait HepekAliases {

  val SiteSettings = html.SiteSettings
  type SiteSettings = html.SiteSettings

  val PageSettings = html.PageSettings
  type PageSettings = html.PageSettings

  // deps
  val Dependency = html.Dependency
  type Dependency = html.Dependency

  val Dependencies = html.Dependencies
  type Dependencies = html.Dependencies

  val DependencyProvider = html.DependencyProvider

  // grid
  val Ratio = html.component.GridComponents.Ratio
  type Ratio = html.component.GridComponents.Ratio

  val Ratios = html.component.GridComponents.Ratios
  type Ratios = html.component.GridComponents.Ratios

  val ScreenRatios = html.component.GridComponents.ScreenRatios
  type ScreenRatios = html.component.GridComponents.ScreenRatios
}
