package br.com.alura.dojoplaces.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class DaysUtilTest {

    @Test
    void between__should_return_dash() {
        LocalDate startDate = LocalDate.parse("2022-01-02");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.DAYS.between(startDate, endDate)).isLessThan(0);
        assertThat(DaysUtil.between(startDate, endDate)).isEqualTo("-");
    }

    @Test
    void between__should_return_today() {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.DAYS.between(startDate, endDate)).isEqualTo(0);
        assertThat(DaysUtil.between(startDate, endDate)).isEqualTo("Hoje");
    }

    @Test
    void between__should_return_day_ago() {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-02");

        assertThat(ChronoUnit.DAYS.between(startDate, endDate)).isEqualTo(1);
        assertThat(DaysUtil.between(startDate, endDate)).isEqualTo("1 dia atrás");
    }

    @Test
    void between__should_return_days_ago() {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-04");

        assertThat(ChronoUnit.DAYS.between(startDate, endDate)).isGreaterThan(1);
        assertThat(DaysUtil.between(startDate, endDate)).isEqualTo("3 dias atrás");
    }
}