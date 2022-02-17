import * as React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { FingerPrint } from 'react-native-fingerprint-auth';

export default function App() {
  const [result, setResult] = React.useState<boolean | undefined>();

  React.useEffect(() => {
    FingerPrint.Authenticate(
      {
        title: 'My App',
        subtitle: 'Authenticate to Unlock',
        description: 'Use fingerprint, pattern or pin to unlock to proceed.',
        usePassword: true,
      },
      (success, error) => {
        setResult(success);
      }
    );
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
