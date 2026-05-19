/*
=========================================================
      API DE FECHAS EN JAVA (java.time)
=========================================================

Desde Java 8 se introdujo el paquete java.time
para trabajar con fechas y horas de forma más
simple y moderna.

ANTES:
- java.util.Date
- Calendar
- GregorianCalendar

AHORA:
- LocalDate
- LocalTime
- LocalDateTime
- Period
- Duration
- ChronoUnit
- DateTimeFormatter

Ventajas:
✔ Más fácil de usar
✔ Código más limpio
✔ Más seguro
✔ Mejor manejo de fechas

=========================================================
*/
package Sintaxis;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class ApuntesFechasJava {

    public static void main(String[] args) {

        /*
        =========================================
        LOCALDATE, LOCALTIME Y LOCALDATETIME
        =========================================

        LocalDate      -> Guarda fechas
        LocalTime      -> Guarda horas
        LocalDateTime  -> Guarda fecha + hora
        */

        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        LocalTime horaActual = LocalTime.now();
        System.out.println("Hora actual: " + horaActual);

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + ahora);


        /*
        =========================================
        CREAR FECHAS Y HORAS MANUALMENTE
        =========================================

        El método of() permite crear una fecha
        u hora concreta.
        */

        LocalDate fechaNacimiento =
                LocalDate.of(1999, 3, 28);

        System.out.println("Fecha nacimiento: "
                + fechaNacimiento);

        LocalTime horaRecreo =
                LocalTime.of(11, 25);

        System.out.println("Hora recreo: "
                + horaRecreo);

        LocalDateTime nacimientoCompleto =
                LocalDateTime.of(
                        1999, 3, 28, 20, 40);

        System.out.println("Nacimiento completo: "
                + nacimientoCompleto);


        /*
        =========================================
        SUMAR Y RESTAR FECHAS
        =========================================

        plusDays()      -> suma días
        plusMonths()    -> suma meses
        minusYears()    -> resta años
        */

        LocalDate nuevaFecha =
                fechaNacimiento.plusDays(5);

        System.out.println("5 días después: "
                + nuevaFecha);

        nuevaFecha =
                nuevaFecha.plusMonths(2);

        System.out.println("2 meses después: "
                + nuevaFecha);

        nuevaFecha =
                nuevaFecha.minusYears(3);

        System.out.println("3 años antes: "
                + nuevaFecha);


        /*
        =========================================
        COMPARAR FECHAS
        =========================================

        isBefore() -> antes
        isAfter()  -> después
        equals()   -> iguales
        */

        LocalDate miFecha =
                LocalDate.of(2000, 5, 10);

        LocalDate tuFecha =
                LocalDate.of(1998, 8, 15);

        if (tuFecha.isBefore(miFecha)) {
            System.out.println("Eres mayor que yo");
        }

        if (miFecha.isAfter(tuFecha)) {
            System.out.println("Soy más joven");
        }


        /*
        =========================================
        CHRONOUNIT
        =========================================

        Sirve para calcular diferencias entre
        fechas u horas.
        */

        long dias =
                ChronoUnit.DAYS.between(
                        tuFecha, miFecha);

        long años =
                ChronoUnit.YEARS.between(
                        tuFecha, miFecha);

        System.out.println("Diferencia días: "
                + dias);

        System.out.println("Diferencia años: "
                + años);


        /*
        =========================================
        PERIOD
        =========================================

        Devuelve diferencias separadas en:
        años, meses y días.
        */

        Period periodo =
                Period.between(tuFecha, miFecha);

        System.out.println("Años: "
                + periodo.getYears());

        System.out.println("Meses: "
                + periodo.getMonths());

        System.out.println("Días: "
                + periodo.getDays());


        /*
        =========================================
        DURATION
        =========================================

        Se usa normalmente para diferencias
        entre horas.
        */

        LocalTime hora1 =
                LocalTime.of(8, 30);

        LocalTime hora2 =
                LocalTime.of(15, 45);

        Duration duracion =
                Duration.between(hora1, hora2);

        System.out.println("Horas diferencia: "
                + duracion.toHours());


        /*
        =========================================
        DAYOFWEEK
        =========================================

        Enum que representa los días de la
        semana.
        */

        DayOfWeek lunes =
                DayOfWeek.MONDAY;

        System.out.println("Día: " + lunes);

        System.out.println("5 días después: "
                + lunes.plus(5));

        System.out.println("Nombre completo: "
                + lunes.getDisplayName(
                        TextStyle.FULL,
                        Locale.getDefault()));


        /*
        =========================================
        MONTH
        =========================================

        Enum que representa los meses.
        */

        Month mes = Month.FEBRUARY;

        System.out.println("Mes: " + mes);

        System.out.println("2 meses después: "
                + mes.plus(2));


        /*
        =========================================
        YEARMONTH
        =========================================

        Representa un mes concreto de un año.
        */

        YearMonth febrero2016 =
                YearMonth.of(
                        2016,
                        Month.FEBRUARY);

        System.out.println(
                "Días febrero 2016: "
                + febrero2016.lengthOfMonth());


        /*
        =========================================
        MONTHDAY
        =========================================

        Representa un día concreto de un mes.
        */

        MonthDay dia =
                MonthDay.of(
                        Month.FEBRUARY,
                        29);

        if (dia.isValidYear(2016)) {
            System.out.println(
                    "29 febrero válido");
        }


        /*
        =========================================
        YEAR
        =========================================

        Representa un año concreto.
        */

        Year añoActual = Year.now();

        if (añoActual.isLeap()) {
            System.out.println("Año bisiesto");
        } else {
            System.out.println("No bisiesto");
        }


        /*
        =========================================
        OBTENER DATOS DE FECHA
        =========================================

        Podemos obtener:
        - día
        - mes
        - año
        - hora
        - minutos
        */

        LocalDate hoy = LocalDate.now();

        System.out.println(
                "Día mes: "
                + hoy.getDayOfMonth());

        System.out.println(
                "Mes: "
                + hoy.getMonthValue());

        System.out.println(
                "Año: "
                + hoy.getYear());


        /*
        =========================================
        FORMATEAR FECHAS
        =========================================

        DateTimeFormatter permite cambiar el
        formato de visualización.
        */

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy");

        System.out.println(
                formato.format(hoy));


        /*
        Patrones comunes:

        dd -> día
        MM -> mes número
        MMMM -> nombre mes
        yyyy -> año
        HH -> hora
        mm -> minutos
        ss -> segundos
        */


        /*
        =========================================
        PARSE
        =========================================

        Convierte un String en una fecha.
        */

        String fechaTexto =
                "2015-12-31";

        LocalDate fechaParseada =
                LocalDate.parse(fechaTexto);

        System.out.println(fechaParseada);


        /*
        Parse con formato personalizado
        */

        DateTimeFormatter patron =
                DateTimeFormatter.ofPattern(
                        "yyyy/MM/dd");

        LocalDate fechaPersonalizada =
                LocalDate.parse(
                        "2014/11/15",
                        patron);

        System.out.println(fechaPersonalizada);
    }
}