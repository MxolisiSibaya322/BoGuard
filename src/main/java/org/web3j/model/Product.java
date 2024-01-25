package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.10.3.
 */
@SuppressWarnings("rawtypes")
public class Product extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610648806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063b56559b214610030575b600080fd5b61036d600480360360c081101561004657600080fd5b810190602081018135600160201b81111561006057600080fd5b82018360208201111561007257600080fd5b803590602001918460018302840111600160201b8311171561009357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156100e557600080fd5b8201836020820111156100f757600080fd5b803590602001918460018302840111600160201b8311171561011857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561016a57600080fd5b82018360208201111561017c57600080fd5b803590602001918460018302840111600160201b8311171561019d57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156101ef57600080fd5b82018360208201111561020157600080fd5b803590602001918460018302840111600160201b8311171561022257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561027457600080fd5b82018360208201111561028657600080fd5b803590602001918460018302840111600160201b831117156102a757600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156102f957600080fd5b82018360208201111561030b57600080fd5b803590602001918460018302840111600160201b8311171561032c57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061036f945050505050565b005b7fad45131245de509fa215414a505fc202648297fb97ef54cbcc50846a914cb4c78686868686866040518080602001806020018060200180602001806020018060200187810387528d818151815260200191508051906020019080838360005b838110156103e75781810151838201526020016103cf565b50505050905090810190601f1680156104145780820380516001836020036101000a031916815260200191505b5087810386528c5181528c516020918201918e019080838360005b8381101561044757818101518382015260200161042f565b50505050905090810190601f1680156104745780820380516001836020036101000a031916815260200191505b5087810385528b5181528b516020918201918d019080838360005b838110156104a757818101518382015260200161048f565b50505050905090810190601f1680156104d45780820380516001836020036101000a031916815260200191505b5087810384528a5181528a516020918201918c019080838360005b838110156105075781810151838201526020016104ef565b50505050905090810190601f1680156105345780820380516001836020036101000a031916815260200191505b5087810383528951815289516020918201918b019080838360005b8381101561056757818101518382015260200161054f565b50505050905090810190601f1680156105945780820380516001836020036101000a031916815260200191505b5087810382528851815288516020918201918a019080838360005b838110156105c75781810151838201526020016105af565b50505050905090810190601f1680156105f45780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390a150505050505056fea265627a7a7231582014879547e32bcb948a0114c7a8a0b28d30f5b6de5deecf8c184bd425fb5fef0d64736f6c63430005110032";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final Event PRODUCTADDEDEVENT_EVENT = new Event("ProductAddedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected Product(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Product(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Product(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Product(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ProductAddedEventEventResponse> getProductAddedEventEvents(TransactionReceipt transactionReceipt) {
        org.web3j.abi.EventValues eventValues = staticExtractEventParameters(PRODUCTADDEDEVENT_EVENT, transactionReceipt.getLogs().get(0));
        List<ProductAddedEventEventResponse> responses = new ArrayList<>();

        for (int i = 0; i < eventValues.getIndexedValues().size(); i++) {
            ProductAddedEventEventResponse typedResponse = new ProductAddedEventEventResponse();
            // Assuming the order of parameters matches the order of fields in your response class
            typedResponse.manufacturer = (String) eventValues.getIndexedValues().get(i).getValue();
            responses.add(typedResponse);
        }

        return responses;
    }

    public static ProductAddedEventEventResponse getProductAddedEventEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PRODUCTADDEDEVENT_EVENT, log);
        ProductAddedEventEventResponse typedResponse = new ProductAddedEventEventResponse();
        typedResponse.log = log;
        typedResponse.manufacturer = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.manufactureDateTime = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.expiryDate = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.productDescription = (String) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.locationManufactured = (String) eventValues.getNonIndexedValues().get(4).getValue();
        typedResponse.batchNumber = (String) eventValues.getNonIndexedValues().get(5).getValue();
        return typedResponse;
    }

    public Flowable<ProductAddedEventEventResponse> productAddedEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProductAddedEventEventFromLog(log));
    }

    public Flowable<ProductAddedEventEventResponse> productAddedEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTADDEDEVENT_EVENT));
        return productAddedEventEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addProduct(String _manufacturer, String _manufactureDateTime, String _expiryDate, String _productDescription, String _locationManufactured, String _batchNumber) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_manufacturer), 
                new org.web3j.abi.datatypes.Utf8String(_manufactureDateTime), 
                new org.web3j.abi.datatypes.Utf8String(_expiryDate), 
                new org.web3j.abi.datatypes.Utf8String(_productDescription), 
                new org.web3j.abi.datatypes.Utf8String(_locationManufactured), 
                new org.web3j.abi.datatypes.Utf8String(_batchNumber)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Product load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Product(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Product load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Product(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Product load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Product(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Product load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Product(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Product> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Product.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Product> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Product.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Product> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Product.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Product> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Product.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ProductAddedEventEventResponse extends BaseEventResponse {
        public String manufacturer;

        public String manufactureDateTime;

        public String expiryDate;

        public String productDescription;

        public String locationManufactured;

        public String batchNumber;
    }
}
