package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecordsController {

    private final RecordRepository recordRepository;

    @GetMapping("/records")
    public Iterable<Record> listRecords() {
        return recordRepository.findAll();
    }

    @PostMapping("/records/{name}/{city}")
    public Record createRecord(@PathVariable String name, @PathVariable String city) {
        return recordRepository.save(Record.builder()
                .city(city)
                .name(name)
                .build());
    }
}
