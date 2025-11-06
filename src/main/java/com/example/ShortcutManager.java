package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ShortcutManager {
    private final List<ShortcutEntry> shortcuts = new ArrayList<>();

    public void addShortcut(ShortcutEntry entry) {
        Objects.requireNonNull(entry, "entry must not be null");

        boolean duplicateId = shortcuts.stream()
            .anyMatch(existing -> existing.getId().equals(entry.getId()));
        if (duplicateId) {
            throw new IllegalArgumentException("Shortcut with id " + entry.getId() + " already exists");
        }

        shortcuts.add(entry);
    }

    public void updateShortcut(ShortcutEntry entry) {
        Objects.requireNonNull(entry, "entry must not be null");

        for (int i = 0; i < shortcuts.size(); i++) {
            if (shortcuts.get(i).getId().equals(entry.getId())) {
                shortcuts.set(i, entry);
                return;
            }
        }

        throw new IllegalArgumentException("Shortcut with id " + entry.getId() + " not found");
    }

    public void deleteShortcut(UUID id) {
        Objects.requireNonNull(id, "id must not be null");

        boolean removed = shortcuts.removeIf(entry -> entry.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Shortcut with id " + id + " not found");
        }
    }

    public String findExpansion(String textToMatch) {
        Objects.requireNonNull(textToMatch, "textToMatch must not be null");

        for (ShortcutEntry entry : shortcuts) {
            String trigger = entry.getKeyword() + entry.getCommand();
            if (textToMatch.equals(trigger)) {
                return entry.getExpansionText();
            }
        }

        return null;
    }

    public List<ShortcutEntry> getShortcuts() {
        return new ArrayList<>(shortcuts);
    }
}
