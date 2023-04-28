package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest {
  
  protected String createOrderBody() {
    // @formatter:off
       return "{\n"
           + "  \"customer\":\"MORISON_LINA\",\n"
           + "  \"model\":\"WRANGLER\",\n"
           + "  \"trim\":\"Sport Altitude\",\n"
           + "  \"door\":\"4\",\n"
           + "  \"color\":\"EXT_DIAMOND_BLACK\",\n"
           + "  \"engine\":\"2_0_TURBO\",\n"
           + "  \"tire\":\"255_GOODYEAR\",\n"
           + "  \"options\":[\n"
           + "  \"DOOR_QUAD_\":\"4\" "
           + "     \"EXT_AEV_LIFT\",\n"
           + "     \"EXT_WARN_WINCH\",\n"
           + "     \"EXT_WARN_BUMPER_FRONT\",\n"
           + "     \"EXT_WARN_BUMPER_REAR\",\n"
           + "     \"EXT_ARB_COMPRESSOR\",\n"
           + "   ]\n"
           +"}";
         // @formatter:on
     } 

}
