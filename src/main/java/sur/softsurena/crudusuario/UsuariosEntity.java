package sur.softsurena.crudusuario;

import java.util.Objects;

public class UsuariosEntity implements Comparable<UsuariosEntity>{
    private static final long serialVersionUID = 1L;

    private Integer id=0;
    private String nombres;
    private String apellidos;
    private Boolean estado;

    @Override
    public boolean equals(Object obj) {
            if (this == obj) {
                    return true;
            }

            if (!(obj instanceof UsuariosEntity)) {
                    return false;
            }

            UsuariosEntity other = (UsuariosEntity) obj;
            return Objects.equals(apellidos, other.apellidos) && 
                            estado == other.estado && 
                            id == other.id && 
                            Objects.equals(nombres, other.nombres);
    }



    @Override
    public int hashCode() {
            return Objects.hash(apellidos, estado, id, nombres);
    }




    public UsuariosEntity(Integer id, String nombres, String apellidos, boolean estado) {
            super();
            this.id = id;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.estado = estado;
    }



    public int getId() {
            return id;
    }



    public void setId(int id) {
            this.id = id;
    }



    public String getNombres() {
            return nombres;
    }



    public void setNombres(String nombres) {
            this.nombres = nombres;
    }



    public String getApellidos() {
            return apellidos;
    }



    public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
    }



    public boolean isEstado() {
            return estado;
    }



    public void setEstado(boolean estado) {
            this.estado = estado;
    }



    @Override
    public String toString() {
            
        
            
   String valor = "<tr class='w3-hover-green'>"
           + "<td>"+id+"</td>"
           + "<td>"+nombres+"</td>"
           + "<td>"+apellidos+"</td>"
           + "<td><input class='w3-check' type='checkbox' disabled "+(estado ? "checked":"")+"></td>"
           + " </tr>";
            
        return valor;
        
//        "UsuariosEntity [id=" + id2 + ", nombres=" + nombres + ", apellidos=" + apellidos + ", estado=" + estado
//                            + "]"
    }


    @Override
    public int compareTo(UsuariosEntity o) {

            return this.id.compareTo(o.id);
    }



    public static long getSerialversionuid() {
            return serialVersionUID;
    }	
}