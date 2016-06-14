package com.kaltura.enrichment

import java.nio.file.{Paths, Files}

import com.kaltura.core.utils.ConfigurationManager
import com.kaltura.model.events.RawPlayerEvent

/**
 * Created by ofirk on 29/05/2016.
 */
class EventsFilter {
  var includeAll = true
  var enabledPartners: Set[Int] = _
  val enabledPartnersFilePath = ConfigurationManager.get("kanalony.events_enrichment.enabled_partners_file_path")
  if(Files.exists(Paths.get(enabledPartnersFilePath))) {
    val source = scala.io.Source.fromFile(enabledPartnersFilePath)
    enabledPartners = try source.getLines.toList.map(_.toInt).toSet finally source.close()
    includeAll = false
  }

  def include(event: RawPlayerEvent): Boolean = includeAll || (event.partnerId.isDefined && enabledPartners.contains(event.partnerId.get))

}
