// ProductVerification.sol
pragma solidity ^0.5.16;

contract Product{
    // Structure to represent product information
    struct ProductInfo {
        string manufacturer;
        string manufactureDateTime;
        string expiryDate;
        string productDescription;
        string locationManufactured;
        string batchNumber;
    }

    // Event emitted when a new product is added
    event ProductAddedEvent(
        string manufacturer,
        string manufactureDateTime,
        string expiryDate,
        string productDescription,
        string locationManufactured,
        string batchNumber
    );

    // Function to add a new product
    function addProduct(
        string memory _manufacturer,
        string memory _manufactureDateTime,
        string memory _expiryDate,
        string memory _productDescription,
        string memory _locationManufactured,
        string memory _batchNumber
    ) public {
        // Emit an event to signify the addition of a new product
        emit ProductAddedEvent(
            _manufacturer,
            _manufactureDateTime,
            _expiryDate,
            _productDescription,
            _locationManufactured,
            _batchNumber
        );
    }
}
