package tech.bootcamp.desafio.ada.utils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TextUtil {

    public static Boolean isStringUsable(String s) {
        return s != null && !s.isEmpty();

    }
}
