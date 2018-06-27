package controlenotas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.FieldUtils;

import controlenotas.annotations.Coluna;

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

    public static <T> void modificar(final T entidade) {

        final Object newvalue = null;

        Stream.of(entidade.getClass().getDeclaredFields())
                        .filter(f -> f.isAnnotationPresent(Coluna.class))
                        .forEach(f -> {
                            f.setAccessible(true);
                            try {
                                f.set(entidade, newvalue);
                            } catch (IllegalArgumentException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        });
    }
}