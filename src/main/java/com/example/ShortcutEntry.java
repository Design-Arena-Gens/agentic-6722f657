package com.example;

import java.util.Objects;
import java.util.UUID;

public class ShortcutEntry {
    private UUID id;
    private String command;
    private String keyword;
    private String expansionText;

    public ShortcutEntry(UUID id, String command, String keyword, String expansionText) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.command = Objects.requireNonNull(command, "command must not be null");
        this.keyword = Objects.requireNonNull(keyword, "keyword must not be null");
        this.expansionText = Objects.requireNonNull(expansionText, "expansionText must not be null");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = Objects.requireNonNull(command, "command must not be null");
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = Objects.requireNonNull(keyword, "keyword must not be null");
    }

    public String getExpansionText() {
        return expansionText;
    }

    public void setExpansionText(String expansionText) {
        this.expansionText = Objects.requireNonNull(expansionText, "expansionText must not be null");
    }
}
