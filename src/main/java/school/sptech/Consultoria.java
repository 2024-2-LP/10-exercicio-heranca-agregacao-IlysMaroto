package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            contratar(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double totalSalarios = 0.0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            totalSalarios += desenvolvedorDaVez.calcularSalario();
        }
        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer quantidadeDesenvolvedoresMobile = 0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile) {
                quantidadeDesenvolvedoresMobile++;
            }
        }
        return quantidadeDesenvolvedoresMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> desenvolvedoresSalarioMaiorIgual = new ArrayList<>();
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez.calcularSalario() >= salario) {
                desenvolvedoresSalarioMaiorIgual.add(desenvolvedorDaVez);
            }
        }
        return desenvolvedoresSalarioMaiorIgual;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores == null || desenvolvedores.isEmpty()) {
            return null;
        } else {
            Desenvolvedor menorSalario = desenvolvedores.get(0);
            for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
                if (menorSalario.calcularSalario() > desenvolvedorDaVez.calcularSalario()) {
                    menorSalario = desenvolvedorDaVez;
                }

            }
            return menorSalario;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresDaTecnologia = new ArrayList<>();

        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedorDaVez).getPlataforma().equals(tecnologia)
                        || ((DesenvolvedorMobile) desenvolvedorDaVez).getLinguagem().equals(tecnologia)) {
                    desenvolvedoresDaTecnologia.add(desenvolvedorDaVez);
                }
            } else if (desenvolvedorDaVez instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedorDaVez).getFrontend().equals(tecnologia)
                        || ((DesenvolvedorWeb) desenvolvedorDaVez).getBackend().equals(tecnologia)
                        || ((DesenvolvedorWeb) desenvolvedorDaVez).getSgbd().equals(tecnologia)) {
                    desenvolvedoresDaTecnologia.add(desenvolvedorDaVez);
                }
            }
        }
        return desenvolvedoresDaTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        double salarioTotalDaTecnologia = 0.0;

        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedorDaVez).getPlataforma().equals(tecnologia)
                        || ((DesenvolvedorMobile) desenvolvedorDaVez).getLinguagem().equals(tecnologia)) {
                    salarioTotalDaTecnologia += desenvolvedorDaVez.calcularSalario();
                }
            } else if (desenvolvedorDaVez instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedorDaVez).getFrontend().equals(tecnologia)
                        || ((DesenvolvedorWeb) desenvolvedorDaVez).getBackend().equals(tecnologia)
                        || ((DesenvolvedorWeb) desenvolvedorDaVez).getSgbd().equals(tecnologia)) {
                    salarioTotalDaTecnologia += desenvolvedorDaVez.calcularSalario();
                }
            }
        }
        return salarioTotalDaTecnologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
