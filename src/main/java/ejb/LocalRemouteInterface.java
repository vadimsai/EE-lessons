package ejb;


//@Remote  // для несольких комьютеров (сеть)
//@Local  // чтобы @inject
public interface LocalRemouteInterface {
    public String getName();
}
