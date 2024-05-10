import dotenv from 'dotenv';
import fs from 'fs';
import path from 'path';

// Load environment variables from .env file
const envFile = path.join(__dirname, './env/.env');
const envConfig = dotenv.parse(fs.readFileSync(envFile));

// Set environment variables
for (const key in envConfig) {
    process.env[key] = envConfig[key];
}