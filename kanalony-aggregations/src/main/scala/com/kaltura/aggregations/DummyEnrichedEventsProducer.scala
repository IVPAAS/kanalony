package com.kaltura.aggregations

import com.kaltura.core.ip2location.Location
import com.kaltura.core.streaming.StreamManager
import com.kaltura.core.urls.UrlParts
import com.kaltura.core.userAgent.UserAgent
import com.kaltura.core.userAgent.enums.{Browser, OperatingSystem, Device}
import com.kaltura.core.utils.ConfigurationManager
import com.kaltura.model.events.{PlayerEventParser, EnrichedPlayerEvent}
import org.apache.kafka.clients.producer.ProducerRecord
import org.joda.time.DateTime

object DummyEnrichedEventsProducer extends App{

  override def main(args: Array[String]): Unit = {
    pushTestEvents()
  }

  def pushTestEvents() = {

    var playerEvent1: EnrichedPlayerEvent = null
    var playerEvent2: EnrichedPlayerEvent = null
    var playerEvent3: EnrichedPlayerEvent = null
    var playerEvent4: EnrichedPlayerEvent = null


    val kafkaBrokers = ConfigurationManager.getOrElse("kanalony.events_enhancer.kafka_brokers","127.0.0.1:9092")
    val producer = StreamManager.createProducer(kafkaBrokers)

    var i = 0
    for( i <- 1 to 1){
      playerEvent1 = EnrichedPlayerEvent(eventType = 3, eventTime = DateTime.now(), partnerId = 1, entryId = "entry1", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))
      playerEvent2 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry1", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))

      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent1)))
      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent2)))

      println(PlayerEventParser.asJson(playerEvent1))
      println(PlayerEventParser.asJson(playerEvent2))

      Thread.sleep(1000*2)


      playerEvent1 = EnrichedPlayerEvent(eventType = 3, eventTime = DateTime.now(), partnerId = 1, entryId = "entry2", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))
      playerEvent2 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry2", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))

      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent1)))
      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent2)))

      println(PlayerEventParser.asJson(playerEvent1))
      println(PlayerEventParser.asJson(playerEvent2))

      Thread.sleep(1000*8)

      playerEvent1 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry1", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))
      playerEvent2 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry2", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))

      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent1)))
      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent2)))

      println(PlayerEventParser.asJson(playerEvent1))
      println(PlayerEventParser.asJson(playerEvent2))

      Thread.sleep(1000*2)

      playerEvent1 = EnrichedPlayerEvent(eventType = 3, eventTime = DateTime.now(), partnerId = 1, entryId = "entry3", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))
      playerEvent2 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry3", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))
      playerEvent3 = EnrichedPlayerEvent(eventType = 99, eventTime = DateTime.now(), partnerId = 1, entryId = "entry4", playbackType = "Live", location = Location(country = "US", city = "NewYork"), userAgent = UserAgent(device = Device.COMPUTER, operatingSystem = OperatingSystem.WINDOWS_10, browser = Browser.CHROME46), urlParts = UrlParts(domain = "www.google.com", canonicalUrl = "www.google.com/a_123", originalUrl = "www.google.com/a_123"))

      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent1)))
      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent2)))
      producer.send(new ProducerRecord[String,String]("enriched-player-events", null, PlayerEventParser.asJson(playerEvent3)))

      println(PlayerEventParser.asJson(playerEvent1))
      println(PlayerEventParser.asJson(playerEvent2))
      println(PlayerEventParser.asJson(playerEvent3))


    }

    producer.close()
  }
}
