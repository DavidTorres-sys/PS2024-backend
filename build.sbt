name := """RedVialMed"""
organization := "PS2024"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.14"

libraryDependencies ++= Seq(
    guice,
    javaJpa,
    javaJdbc,
    "org.postgresql" % "postgresql" % "42.7.3",
    "javax.persistence" % "javax.persistence-api" % "2.2",
    "org.hibernate" % "hibernate-core" % "6.5.2.Final",
    "jakarta.persistence" % "jakarta.persistence-api" % "3.2.0",
    "org.projectlombok" % "lombok" % "1.18.34",
    "org.mapstruct" % "mapstruct" % "1.5.5.Final",
    "org.mapstruct" % "mapstruct-processor" % "1.5.5.Final" % "provided",
    "io.micrometer" % "micrometer-registry-prometheus" % "1.13.2",
    "io.swagger.core.v3" % "swagger-core" % "2.2.8",
    "io.swagger.core.v3" % "swagger-annotations" % "2.2.8",
    "com.typesafe.play" %% "play-filters-helpers" % "2.9.5"
)

resolvers += "Maven Central" at "https://repo1.maven.org/maven2/"
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

