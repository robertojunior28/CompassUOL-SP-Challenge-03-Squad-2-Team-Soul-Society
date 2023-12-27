package br.com.compassuol.pb.challenge.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    OPERATOR("OPERATOR");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
