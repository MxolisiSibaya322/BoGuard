# Boguard: Product Authentication System

## Overview

Welcome to Boguard, a powerful product authentication system designed to combat counterfeiting and ensure the authenticity of products. This system utilizes blockchain technology and QR codes to provide end-users with a seamless and trustworthy way to verify product details.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Getting Started](#getting-started)
   - [Installation](#installation)
   - [Configuration](#configuration)
4. [Usage](#usage)
   - [Manufacturer Upload](#manufacturer-upload)
   - [User Verification](#user-verification)
5. [Blockchain Integration](#blockchain-integration)
6. [Database Management](#database-management)
7. [Verification Link](#verification-link)
8. [Contributing](#contributing)
9. [License](#license)

## Introduction

Boguard is a system developed to help manufacturers protect their products from counterfeiting. The system generates unique QR codes containing product details and a hash code, which users can scan to verify the authenticity of the product. The core of Boguard is built on blockchain technology, ensuring a secure and tamper-proof record of product information.

## Features

- **Blockchain Integration:** All product information is stored securely on the blockchain, ensuring transparency and immutability.

- **QR Code Generation:** Manufacturers can easily generate QR codes containing product details and a hash code for each item.

- **User Verification:** End-users can scan the QR code to access a verification link, confirming the authenticity of the product.

- **Database Management:** The system maintains a database of product details and hash codes for efficient verification.

## Getting Started

### Installation

Installation process to be confirmed, for now simply:

1. Clone the repository: `git clone https://github.com/MxolisiSibaya322/BoGuard.git`
2. Navigate to the project directory: `cd boguard`
3. Run "Application.main" to start the server.

Endpoints:
/addproduct : used to capture product information
/verfify/{hashcode} : used to verifiy a products authenticity 

### Configuration

For now the configuration details such as blockchain credentials are store in code. See the Web3Engine package.

## Usage

### Manufacturer Upload

1. Manufacturers upload product details to the system, triggering the creation of a unique QR code for each product.

### User Verification

1. End-users scan the QR code using a mobile device or QR code scanner.
2. The system redirects the user to a verification link, passing the hash code.
3. The hash code is verified against the blockchain, and upon success, the user receives a response with a tick and the product details.

## Blockchain Integration

Boguard utilizes blockchain technology for storing product information. Each product has a corresponding smart contract transaction that ensures data integrity.

## Database Management

The system maintains a database of product details and hash codes for quick and efficient verification.

## Verification Link

The verification link is a crucial component, connecting the QR code to the blockchain. It validates the hash code and provides users with real-time confirmation of a product's authenticity.

## Contributing

We welcome contributions!

## License

Boguard is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it according to your needs.
