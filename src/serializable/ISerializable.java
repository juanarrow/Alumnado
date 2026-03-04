package serializable;

public interface ISerializable {    
    public static String serialize(ISerializable item){
        return item.serialize();
    }
    
    public static ISerializable deserialize(String data, ISerializable item){
        return item.deserialize(data);
    }

    public String serialize();

    public ISerializable deserialize(String data);

    public Long getId();
}
