package br.com.murilokakazu.ec7.ftt.cefsa.infrastructure.formatter;

public class SQLFormatter {

    public static String formatLowerCaseLikeContains(String value) {
        return '%' + value.toLowerCase() + '%';
    }

}
