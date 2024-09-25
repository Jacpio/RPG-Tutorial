package pl.jacpio.entities.components;

import java.util.Arrays;

public class DialogueData {
    private Dialogue[] dialogues;
    private int currentDialogueIndex = 0;

    public Dialogue[] getDialogues() {
        return dialogues;
    }

    public int getCurrentDialogueIndex() {
        return currentDialogueIndex;
    }

    public void setCurrentDialogueIndex(int currentDialogueIndex) {
        this.currentDialogueIndex = currentDialogueIndex;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DialogueData{");
        sb.append("dialogues=").append(dialogues == null ? "null" : Arrays.asList(dialogues).toString());
        sb.append(", currentDialogueIndex=").append(currentDialogueIndex);
        sb.append('}');
        return sb.toString();
    }

    public static class Dialogue {
        private int id;
        private String message;
        private Option[] options;

        public String getMessage() {
            return message;
        }

        public Option[] getOptions() {
            return options;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Dialogue{");
            sb.append("id=").append(id);
            sb.append(", message='").append(message).append('\'');
            sb.append(", options=").append(options == null ? "null" : Arrays.asList(options).toString());
            sb.append('}');
            return sb.toString();
        }

        public static class Option {
            private String text;
            private int nextID;

            public String getText() {
                return text;
            }

            public int getNextID() {
                return nextID;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Option{");
                sb.append("text='").append(text).append('\'');
                sb.append(", nextID=").append(nextID);
                sb.append('}');
                return sb.toString();
            }
        }

    }
}
