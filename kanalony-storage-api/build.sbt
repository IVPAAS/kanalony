lazy val `kanalony-storage-access` = RootProject(file("../kanalony-storage-access"))
lazy val `kanalony-storage-api` = (project in file(".")).
  settings(
    name := "kanalony-storage-api",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "com.websudos"  %% "phantom-dsl"                   % "1.22.0",
      "com.websudos"  %% "phantom-testkit"               % "1.12.2",
      "com.typesafe"  % "config"                         % "1.3.0"
    )
  ).dependsOn(`kanalony-storage-access`)

    