package app.block5crudValidation.shared.enums;

import lombok.ToString;

@ToString
public enum Branch {
    FRONT("FRONT"),
    BACK("BACK"),
    FULLSTACK("FULLSTACK"),
    DEVOPS("DEVOPS"),
    UNASSIGNED("UNASSIGNED");

    private final String displayName;

    Branch(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
