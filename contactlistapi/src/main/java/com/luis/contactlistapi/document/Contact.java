package com.luis.contactlistapi.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Document
public class Contact {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private LocalDate createdAt;
}
