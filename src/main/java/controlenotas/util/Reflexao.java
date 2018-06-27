package controlenotas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * Classe auxiliar para reflexão em outras classes a fim de diminuir repetição de código
 *
 * @author pedrosousa
 *
 */
public class Reflexao {

    public static Object readDeclaredField(final Object instancia, final String nomeAtributo) throws IllegalAccessException {

        return FieldUtils.readDeclaredField(instancia, nomeAtributo, true);
    }

    public static Date toDate(final String date) {

        Date localDate = null;
        final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            localDate = format.parse(date);
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        return localDate;
    }

    public static <T> T getInstance(final Class<T> clazz) throws InstantiationException, IllegalAccessException {

        final T instance = clazz.newInstance();

        return instance;
    }

}