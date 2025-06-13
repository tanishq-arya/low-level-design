// This class represents the actual network service that fetches data from a remote server.

package ProxyPattern.Exercise;

public class RealNetworkService implements NetworkService {

    @Override
    public String fetchData(String input) {
        return "Data fetched from remote server for input: " + input;
    }
}