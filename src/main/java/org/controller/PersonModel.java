package org.controller;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class PersonModel {
    @NotNull
    @Schema(required = true,examples="Aiden")
    public String firstName;
    @NotNull
    @Schema(required = true,examples="Tumesigye")
    public String lastName;
    public String otherName;
}
