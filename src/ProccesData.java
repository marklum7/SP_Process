class ProccesData {
    String Priority;
    String Type;
    String PID;
    String Name;

    ProccesData(String name, String pid, String Type, String Priority) {
        System.out.printf("Created!");
        this.Priority = Priority;
        this.PID = pid;
        this.Name = name;
        this.Type = Type;
    }

    public String getPID() {
        return PID;
    }

    public String getName() {
        return Name;
    }

    public String getPriority() {
        return Priority;
    }

    public String getType() {
        return Type;
    }
}