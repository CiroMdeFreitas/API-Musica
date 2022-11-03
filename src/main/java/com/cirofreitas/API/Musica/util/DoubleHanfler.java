package com.cirofreitas.API.Musica.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DoubleHanfler {
    public static Double formatarParaDuasCasasDecimais(Double valor) {
        DecimalFormat formatadorDecimal = new DecimalFormat("#.##");
        DecimalFormatSymbols simboloDeximal = new DecimalFormatSymbols();
        simboloDeximal.setDecimalSeparator('.');
        formatadorDecimal.setDecimalFormatSymbols(simboloDeximal);
        formatadorDecimal.setRoundingMode(RoundingMode.HALF_EVEN);

        return Double.parseDouble(formatadorDecimal.format(valor));
    }
}
