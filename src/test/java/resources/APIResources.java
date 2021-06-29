package resources;

public enum APIResources {
    loginToken("/startemmi-svc/api/login/token"),
    programsPicker("/startemmi-svc/api/programs/picker/{viewGroupCode}?language=en");

    private String resource;

    APIResources(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
