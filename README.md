# react-native-fingerprint-auth

React Native library for native fingerprint authentication(android only)

## Installation

```sh
npm install react-native-fingerprint-auth
```

or

```sh
yarn add react-native-fingerprint-auth
```

## Android Permissions

```xml
<uses-permission android:name="android.permission.USE_BIOMETRIC"/>
```

## Usage

```js
import { FingerPrint } from 'react-native-fingerprint-auth';

const configObject = {
  title: 'My App',
  subtitle: 'Authenticate to Unlock',
  description: 'Use fingerprint, pattern or pin to unlock to proceed.',
  usePassword: true,
};
FingerPrint.Authenticate(configObject, (success, error) => {
  console.log(success, error);
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
