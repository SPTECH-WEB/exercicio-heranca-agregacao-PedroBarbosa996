package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
   private String backend;
   private String frontend;
   private String sgbd;
   private Integer horasMentoria;

    public Double calcularSalario(){
        return qtdHoras*valorHora + (horasMentoria*300);
    }

    public Boolean isFullstack(){
        if (backend == null || frontend == null || sgbd == null){
            return false;
        }
        return true;
    }

    public String getBackend() {
        return backend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }
}
