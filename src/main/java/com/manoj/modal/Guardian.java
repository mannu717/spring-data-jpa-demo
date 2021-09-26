package com.manoj.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(
                        name = "guardian_name",
                        length = 50
                )
        ),
        @AttributeOverride(
                name = "phone",
                column = @Column(
                        name = "guardian_phone",
                        length = 12
                )
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(
                        name = "guardian_email_address"
                )
        )
})
public class Guardian {

    private String name;
    private String phone;
    private String email;
}
