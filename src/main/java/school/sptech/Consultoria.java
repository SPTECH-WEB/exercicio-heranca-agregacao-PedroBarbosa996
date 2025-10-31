package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria extends Desenvolvedor{
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas > 0 && desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double somaSalarios = 0.0;
        for(Desenvolvedor d : desenvolvedores){
            somaSalarios += d.calcularSalario();
        }
        return somaSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int somaDesenvolvedoresMobile = 0;
        for(Desenvolvedor d : desenvolvedores){
            if(d instanceof DesenvolvedorMobile){
                somaDesenvolvedoresMobile+=1;
            }
        }
        return somaDesenvolvedoresMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresMaiorSalario = new ArrayList<>();
        for(Desenvolvedor d : desenvolvedores){
            if (d.calcularSalario() > salario){
                desenvolvedoresMaiorSalario.add(d);
            }
        }
        return desenvolvedoresMaiorSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        double salario = 0.0;
        for (Desenvolvedor d : desenvolvedores){
            if (d.calcularSalario() > salario){
                salario = d.calcularSalario();
            }
        }

        Desenvolvedor desenvolvedorMenorSalario = null;

        for (Desenvolvedor d : desenvolvedores){
            if (d.calcularSalario() < salario){
                salario = d.calcularSalario();
                desenvolvedorMenorSalario = d;
            }
        }
        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresTecnologia = new ArrayList<>();

        for (Desenvolvedor d : desenvolvedores){
            if (d instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) d).getPlataforma().equals(tecnologia)){
                    desenvolvedoresTecnologia.add(d);
                } else if (((DesenvolvedorMobile) d).getLinguagem().equals(tecnologia)){
                    desenvolvedoresTecnologia.add(d);
                }
            }

            if (d instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) d).getBackend().equals(tecnologia)){
                    desenvolvedoresTecnologia.add(d);
                }else if (((DesenvolvedorWeb) d).getFrontend().equals(tecnologia)){
                    desenvolvedoresTecnologia.add(d);
                }else if (((DesenvolvedorWeb) d).getSgbd().equals(tecnologia)){
                    desenvolvedoresTecnologia.add(d);
                }
            }
        }
        return desenvolvedoresTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        double salariosTecnologias = 0.0;
        for (Desenvolvedor d : buscarPorTecnologia(tecnologia)){
            salariosTecnologias += d.calcularSalario();
        }
        return salariosTecnologias;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}