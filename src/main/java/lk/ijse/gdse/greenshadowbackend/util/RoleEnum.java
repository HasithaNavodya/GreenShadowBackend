package lk.ijse.gdse.greenshadowbackend.util;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RoleEnum {
    MANAGER, ADMINISTER, SCIENTIST, OTHER;
    @JsonCreator
    public static RoleEnum fromString(String role) {
        return RoleEnum.valueOf(role.toUpperCase());
    }
}
