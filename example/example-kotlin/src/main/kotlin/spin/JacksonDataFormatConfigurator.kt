package io.holunda.camunda.bpm.data.example.kotlin.spin

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat
import org.camunda.spin.spi.DataFormatConfigurator

class JacksonDataFormatConfigurator : DataFormatConfigurator<JacksonJsonDataFormat> {

    override fun configure(dataFormat: JacksonJsonDataFormat) {
        val objectMapper = dataFormat.objectMapper
        objectMapper.registerModule(KotlinModule())
    }

    override fun getDataFormatClass(): Class<JacksonJsonDataFormat> = JacksonJsonDataFormat::class.java

}
