# @react-native/fingerprint

React Native library for native fingerprint auth

## Installation

```sh
npm install @react-native/fingerprint
```

## Usage

```js
import { Authenticate } from '@react-native/fingerprint';

const configObject = {
  title: 'My App',
  subtitle: 'Authenticate to Unlock',
  description: 'Use fingerprint, pattern or pin to unlock to proceed.',
  usePassword: true,
};
Authenticate(configObject, (success, error) => {
  console.log(success, error);
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
