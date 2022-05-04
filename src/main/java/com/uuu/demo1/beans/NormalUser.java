package com.uuu.demo1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser {
    @NotNull(message = "This field doesn't allow empty")
    private String name;
}
