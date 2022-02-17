import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package '@react-native/fingerprint' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const Fingerprint = NativeModules.Fingerprint
  ? NativeModules.Fingerprint
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );
export function Authenticate(
  configObject: {
    title: String;
    subtitle: String;
    description: String;
    usePassword: Boolean;
  },
  callback: (success: boolean, error: String) => void
) {
  const { title, subtitle, description, usePassword } = configObject;
  return Fingerprint.useFingerPrint(
    title,
    subtitle,
    description,
    usePassword,
    callback
  );
}
