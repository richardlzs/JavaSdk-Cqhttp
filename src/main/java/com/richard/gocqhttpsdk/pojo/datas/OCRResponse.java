package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OCRResponse {
    private List<Text> texts;
    private String language;

    @Data
    public static class Text {
        private String text;
        private int confidence;
        private List<Coordinate> coordinates;
    }

    @Data
    public static class Coordinate {
        private int x;
        private int y;
    }
}
