package com.homework.flow.exts.dto.extension;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtensionDTO {

    private  Long id;
    private  String name;
    private boolean flagUse;
    private boolean flagFixed;
}
