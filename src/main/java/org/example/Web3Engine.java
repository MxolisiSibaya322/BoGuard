package org.example;

import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.model.Product;


public class Web3Engine {
    public static Web3j web3j;
    public static Credentials credentials;
    public static String contractAddress;
    public Web3Engine(){
        //geth --dev --ipcpath geth.ipc
        String ipcPath = "/tmp/geth.ipc";

        // Create a Web3j instance with the IPC provider
        web3j = Web3j.build(new UnixIpcService(ipcPath));
//        web3j = Web3j.build(new HttpService("http://localhost:8545"));
        credentials = Credentials.create("45d117e4174f10c16de97c2c050550a766fc7dc8f85cab6d0d7c00aedcc65834"); // Replace with your Ethereum account private key
        contractAddress = "0x6189B1C96b530819B162Ae93fdF56Bc4B291e7C5"; // Replace with your deployed contract address
    }

    public static void addProduct(Web3j web3j, Credentials credentials, String contractAddress, String manufacturer, String manufactureDateTime, String expiryDate, String productDescription, String locationManufactured, String batchNumber  ) throws Exception {
        Product contract = Product.load(contractAddress, web3j, credentials, new DefaultGasProvider());

        contract.addProduct(manufacturer, manufactureDateTime, expiryDate, productDescription, locationManufactured, batchNumber).send();
    }

}
