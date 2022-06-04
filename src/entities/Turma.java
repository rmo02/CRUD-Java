package entities;

public class Turma {

	private Integer id;
	private String nome;
    private String curso;
	private String andar;
	private String dataCadastro;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
        this.nome = nome;
	}

    public String getCurso() {
        return curso;
    } 

    public void setCurso(String curso) {
        this.curso = curso;
    }

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}


	public String getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
		
}
