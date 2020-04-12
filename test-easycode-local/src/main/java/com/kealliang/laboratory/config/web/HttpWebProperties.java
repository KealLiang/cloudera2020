package com.kealliang.laboratory.config.web;

import lombok.Data;

/**
 * @author lsr
 * @ClassName HttpWebProperties
 * @Date 2020-04-11
 * @Vertion 1.0
 */
@Data
public class HttpWebProperties {

    private HttpServletResponse response = new HttpServletResponse();

    @Data
    public static class HttpServletResponse {
        private Processor processor = new Processor();
    }

    @Data
    public static class Processor {
        private boolean returnValue = true;
    }
}
