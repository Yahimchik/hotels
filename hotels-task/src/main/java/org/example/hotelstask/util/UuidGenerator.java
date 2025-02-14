package org.example.hotelstask.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
