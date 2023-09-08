package Aulas;

import java.math.BigDecimal;

public class Empregado implements Comparable {
        private String nome;
        private int matricula;
        private BigDecimal teste;
        public Empregado(String nome, int matricula, BigDecimal teste) {
            this.nome=nome;
            this.matricula=matricula;
            this.teste=teste;
        }

        @Override
        public int compareTo(Object other) {
            Empregado empregado = (Empregado) other;
            if (this.matricula < empregado.matricula) {
                return -1;
            }
            if (this.matricula > empregado.matricula) {
                return 1;
            }
            return 0;
        }
    }
