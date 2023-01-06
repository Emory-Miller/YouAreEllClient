import { IMember } from 'app/shared/model/member.model';
import { IMessage } from 'app/shared/model/message.model';

export interface IChannel {
  id?: number;
  name?: string | null;
  description?: string | null;
  members?: IMember[] | null;
  message?: IMessage | null;
}

export const defaultValue: Readonly<IChannel> = {};
