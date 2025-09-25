#!/bin/bash

echo "🔧 Running Drone Debug Tests..."

# Run the debug tests
mvn test -Dtest=DroneDebugTest
